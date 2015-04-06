[![开源实验室](https://github.com/FinalLody/Direct-Load-apk/blob/master/logo.png)](http://www.kymjs.com/)<h2>Direct-Load-apk(DLA)简介</h2>

## 一句话
作为Android开发者，你尝试过运行一个没有安装过的APK吗？你尝试过没有任何约束的去启动一个APK吗？你尝试过不安装QQ微信就直接运行它们吗？很显然，这目前不可能实现。<br>
好吧，说正事，DLA可以做到随时去运行一个apk，而不需要有什么约束，你甚至指定类名来启动插件中的任意Activity。<br>

## 相关连接
* QQ群：[362901808](http://jq.qq.com/?_wv=1027&k=SKRiD0);[257053751](http://jq.qq.com/?_wv=1027&k=WoM2Aa)<br>
* 开源中国git(优先更新)：[http://git.oschina.net/lody/Direct-load-apk](http://git.oschina.net/lody/Direct-load-apk)<br>
* 开源实验室主页：[http://www.kymjs.com/DLA](http://www.kymjs.com/blog/2015/04/01/DLA.html)

## 使用方法
1、你要确保你的插件的Manifest文件中只有Activity声明。<br>
2、在你的宿主APP中添加 **com.lody.plugin.LActivityProxy** 的Activity声明。<br>
3、在你想调用插件的代码处(仅限主线程)调用如下语句<br>
```java
/**
 * @param path 插件在手机中的绝对路径
 */
LPluginOpener.startPlugin(context,path);

```
还有什么？没了！你完全可以把插件交给一个人开发，宿主APP交给一个人开发。

## 未来的支持
如你所见，现在DLA已经能够加载插件中的Activity，而其它三大组件的支持，只是时间问题。<br>
还有一个支持点是主题皮肤加载，这个也是我们接下来要努力做到的功能。<br>
如果你还有其他的希望加入的需求，欢迎来[这里](http://jq.qq.com/?_wv=1027&k=SKRiD0)向我们反馈。<br>

## 开源协议ApacheLicense

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


## 作者
lody，来自浙江宁波的Android开发者。乐于交友，善于分享。
