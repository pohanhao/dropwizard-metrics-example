package idv.hank.dropwizard.metrics.example.managed;

import io.dropwizard.lifecycle.Managed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MetricReporter implements Managed {

    private static final Logger logger = LoggerFactory.getLogger(MetricReporter.class);
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void start() throws Exception {
        executorService.execute(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                logger.info("current time is {}", new Date());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    logger.warn("fail to sleep", e);
                }
            }
        });
    }


    @Override
    public void stop() throws Exception {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    logger.warn("Pool did not terminate");
                }
            }
        } catch (InterruptedException ie) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
