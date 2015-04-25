[![开源实验室](http://www.kymjs.com/image/logo_s.png)](http://www.kymjs.com/)<h2>Direct-Load-apk(DLA)</h2>

## Description
As an Android developer, have you tried to run an **uninstalled APK** ? Have you tried to start an APK **without any constraint** ?  <br>
DLA is a powerful pluggable framework to implement this function. By use it , you can not only to run an uninstalled APK **directly**  , But also you can choose an Activity or Service from any APK to run!<br>

## Related links
* QQ Group in China：[362901808](http://jq.qq.com/?_wv=1027&k=SKRiD0);<br>
* Git@OSC：[ http://git.oschina.net/lody/Direct-load-apk ]<br>
* Open laboratory's Home page：[http://www.kymjs.com/DLA](http://www.kymjs.com/blog/2015/04/01/DLA.html)

## Usage
1、Add **com.lody.plugin.LActivityProxy** tag in your host APP's AndroidManifest.xml.<br>
2、Add **com.lody.plugin.LProxyService** tag in your host APP's AndroidManifest.xml.<br>
3、Add the following code when you want to start an Plugin.<br>
```java
/**
 * @param context
 * @param path 
 */
LPluginOpener.startPlugin(context,path);

```
If you only want to start an Activity from an apk,you can write down the code like this.<br>
```java
/**
 * @param path 
 * @param activityClassName 
 */
LPluginOpener.startActivity(context,path,activityClassName);

```
If you only want to start an Service from an apk,you can write down the code like this.<br>
```java
/**
 * @param path 
 * @param serviceClassName 
 */
LPluginOpener.startService(context,path,serviceClassName);

```
What else? No! The use of DLA is so simple.
## Future support
As you can see,  DLA has been able to load the plug-in for Application, Activity and Service, and the other components's support is only a matter of time!
Another support point is the theme of the skin loading, this is also a target.<br>
If you have any other requirements, welcome to [Here](http://jq.qq.com/?_wv=1027&k=SKRiD0).<br>

## Apache License

Copyright 2015, Lody.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.


## Author
**Lody**，an Android developer from ZheJiang NingBo.Willing to make friends, like to share.

