import { PluginListenerHandle } from "@capacitor/core";

export interface ScreenRecorderPlugin {
  /**
   * start the recording
   *
   */
  start(): Promise<void>;
  /**
   * stop the recording
   *
   */
  stop(): Promise<void>;
  /**
   * pause the recording
   *
   */
  pause(): Promise<void>;
  /**
   * resume the recording
   *
   */
  resume(): Promise<void>;
  /**
   * Callback to finish the recording and obtain the file.
   *
   */
   addListener(
    eventName: 'screenRecordingStop',
    listenerFunc: (data: any) => {},
  ): Promise<PluginListenerHandle> & PluginListenerHandle;
}
