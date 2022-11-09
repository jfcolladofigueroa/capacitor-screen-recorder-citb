package ee.forgr.plugin.screenrecorder;

import android.util.Log;

import androidx.annotation.NonNull;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.jetbrains.annotations.NotNull;

import java.io.File;

import dev.bmcreations.scrcast.ScrCast;
import dev.bmcreations.scrcast.config.Options;
import dev.bmcreations.scrcast.recorder.RecordingCallbacks;
import dev.bmcreations.scrcast.recorder.RecordingState;

@CapacitorPlugin(name = "ScreenRecorder")
public class ScreenRecorderPlugin extends Plugin {

    private ScrCast recorder;
    private RecordingCallbacks recordingCallbacks;

    @Override
    public void load() {
        recorder =  ScrCast.use(this.bridge.getActivity());
        Options options = new Options();
        recorder.updateOptions(options);
        recorder.setRecordingCallback(new RecordingCallbacks() {
            @Override
            public void onStateChange(@NonNull RecordingState recordingState) {
                Log.e("New state collado:", recordingState.toString());
            }

            @Override
            public void onRecordingFinished(@NotNull File file) {
                JSObject ret = new JSObject();
                ret.put("path", file.getAbsolutePath());
                notifyListeners("screenRecordingStop", ret);
            }
        });
    }

    @PluginMethod
    public void start(PluginCall call) {
        recorder.record();
        call.resolve();
    }
    
    @PluginMethod
    public void stop(PluginCall call) {
        recorder.stopRecording();
        call.resolve();
    }

}
