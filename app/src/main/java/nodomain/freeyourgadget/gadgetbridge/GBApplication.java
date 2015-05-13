package nodomain.freeyourgadget.gadgetbridge;

import android.app.Application;
import android.content.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.util.FileUtil;
import ch.qos.logback.core.util.StatusPrinter;

public class GBApplication extends Application {
    private static GBApplication context;

    public GBApplication() {
        context = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        setupLogFileDir();
//        For debugging problems with the logback configuration
//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//         print logback's internal status
//        StatusPrinter.print(lc);
//        String dataDir = lc.getProperty(CoreConstants.DATA_DIR_KEY);
//        String filename = FileUtil.prefixRelativePath(dataDir, "gadgetbridge.log");
//        Logger logger = LoggerFactory.getLogger(GBApplication.class);
    }

    private void setupLogFileDir() {
        File dir = getExternalFilesDir(null);
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }
        // used by assets/logback.xml since the location cannot be statically determined
        System.setProperty("GB_LOGFILES_DIR", dir.getAbsolutePath());
    }

    public static Context getContext() {
        return context;
    }
}
