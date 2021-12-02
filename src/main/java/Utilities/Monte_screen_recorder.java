package Utilities;

import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.*;
import static org.monte.media.VideoFormatKeys.QualityKey;
import static Utilities.manage_DDT.get_data;

public class Monte_screen_recorder extends ScreenRecorder {

    public static ScreenRecorder screen_recorder;
    public String name;
    public Monte_screen_recorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                               Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        }
        else if (!movieFolder.isDirectory()) {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }
        System.out.println("Recorded Screen Cast File is Now Created");
        return new File(movieFolder,
                name + "." + Registry.getInstance().getExtension(fileFormat));
    }

    public static void start_record(String methodName) throws Exception {
        File file = new File(get_data("RecordRepo"));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        Rectangle captureSize = new Rectangle(0, 0, width, height);
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice()
                .getDefaultConfiguration();
        screen_recorder = new Monte_screen_recorder(gc, captureSize,
                new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file, methodName);
        screen_recorder.start();
    }

    public static void stop_record() throws Exception {
        screen_recorder.stop();
        System.out.println("Recorded Screen Cast File Stop Recording");
    }
}
