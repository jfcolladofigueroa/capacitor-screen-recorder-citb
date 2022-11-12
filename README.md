# capacitor-screen-recorder
  <a href="https://capgo.app/"><img src='https://raw.githubusercontent.com/Cap-go/capgo/main/assets/capgo_banner.png' alt='Capgo - Instant updates for capacitor'/></a>
  
<div align="center">
<h2><a href="https://capgo.app/">Check out: Capgo — Instant updates for capacitor</a></h2>
</div>

Record device's screen

## Install

```bash
npm install @capgo/capacitor-screen-recorder
npx cap sync
```

## IOS

Nothing special

## Android

increase project's minSdk version to at least 23.

## API

<docgen-index>

* [`start()`](#start)
* [`stop()`](#stop)
* [`pause()`](#pause)
* [`resume()`](#resume)
* [`addListener(...)`](#addlistener)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### start()

```typescript
start() => Promise<void>
```

start the recording

--------------------


### stop()

```typescript
stop() => Promise<void>
```

stop the recording

--------------------


### pause()

```typescript
pause() => Promise<void>
```

pause the recording

--------------------


### resume()

```typescript
resume() => Promise<void>
```

resume the recording

--------------------


### addListener(...)

```typescript
addListener(eventName: 'screenRecordingStop', listenerFunc: (data: any) => {}) => Promise<PluginListenerHandle> & PluginListenerHandle
```

Callback to finish the recording and obtain the file.

| Param              | Type                               |
| ------------------ | ---------------------------------- |
| **`eventName`**    | <code>"screenRecordingStop"</code> |
| **`listenerFunc`** | <code>(data: any) =&gt; {}</code>  |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |

</docgen-api>
