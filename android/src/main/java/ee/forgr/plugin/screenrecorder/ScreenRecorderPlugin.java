package ee.forgr.plugin.screenrecorder;

import com.getcapacitor.Plugin;

import android.util.Log;

import androidx.annotation.NonNull;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.jetbrains.annotations.NotNull;

import java.io.File;

import ee.forgr.plugin.screenrecorder.scrcast.ScrCast;
import ee.forgr.plugin.screenrecorder.scrcast.config.Options;
import ee.forgr.plugin.screenrecorder.scrcast.recorder.RecordingCallbacks;
import ee.forgr.plugin.screenrecorder.scrcast.recorder.RecordingState;

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

    @PluginMethod
    public void pause(PluginCall call) {
        recorder.pause();
        call.resolve();
    }

    @PluginMethod
    public void resume(PluginCall call) {
        recorder.resume();
        call.resolve();
    }

}
