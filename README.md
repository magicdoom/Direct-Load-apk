Direct-load-apk
===================
![enter image description here](http://www.xiaoxiongbizhi.com/wallpapers/1152_864_85/u/x/uxcccgx3r.jpg)

Description
-------------

Direct - load - apk is a very powerful plugin framework, through it, you can achieve incredible function ----- **load a normal apk as a plug-in directly without install it!** 

> **Advantage:** 
> - Direct - load - apk can load all **Resources** from an apk which loaded as a plug-in. 
> - Start a Service defined plug-in apk directly.
> - Start a Activity defined plug-in apk directly.
> - Start a Application defined plug-in apk directly.
> - Support apk with so library.
> - Support jumping between any Activities in plug-in apk . 
> - Don't like "**[dynamic load - apk](https://github.com/singwhatiwanna/dynamic-load-apk)**" , [**"Direct - load - apk"**](https://github.com/asLody/Direct-load-apk) do not need to inherit the custom Activity, and can directly use `this` pointer. 

#### ***Usage***

Direct - load - apk is very convenient to use .You can write to start an APK likes this:

    LPluginOpener.startPlugin(Context,Path);

> **Tip:** Don't forget to write **com.lody.plugin.LActivityProxy** in AndroidManifest.xml.

#### The development **Progress** and **TODO**
> - Service support in the near.
> -  Run the apk which is included the file of ".so" in the near.
> - Support Plug-in security isolation system In the future.

**Author**
-------------
     Lody, from China, who is An ideal are ambitious young man.
If you have any question , please send **Email** to here: **382816028@qq.com** , You can also Contact me through **QQ**:**382816028**.

##QQ GROUP:
###362901808


#中文版

Direct-load-apk
===================
描述
-------------

Direct - load - apk 是一个强大的插件化框架, 通过使用它, 你可以实现看似不可能实现的功能 ----- **直接加载一个普通apk!** 

> **优势:** 
> - Direct - load - apk 能够加载插件的全部 **资源**. 
> - 支持直接启动插件的Service.
> - 支持直接启动插件的Activity.
> - 支持直接启动插件的Application.
> - 支持运行带有.so的apk.
> - 支持 *插件间* Activity跳转. 
> - 不像 **"[dynamic load - apk](https://github.com/singwhatiwanna/dynamic-load-apk)"** 这个项目, [**"Direct - load - apk"**](https://github.com/FinalLody/Direct-Load-apk/) 不需要对插件有任何约束，也不需要在插件中引入jar和继承自定义Activity，可以直接使用this指针。


使用方法
---------------

Direct - load - apk 的使用相当方便，可以像这样写:

    LPluginOpener.startPlugin(Context,Path);

> **提示:** 不要忘了在 AndroidManifest.xml 加入 **com.lody.plugin.LActivityProxy** .

开发 **进度** 和 **未来将要做的**
----------------------------------------------
> - 未来将提供完整的插件异常处理机制。
> - 未来将完善Preference机制。
> - 未来将实现为插件定制的PackageManager。
> - 未来将实现主题皮肤化机制。
> - 未来将实现对Fragment的独立管理。

**作者**
-------------
     Lody, 一个富有开源精神和创造力的Android开发者。
如果你有任何问题 , 可以发送 **Email** 到 *382816028@qq.com* , 也可以联系我的 *QQ* :382816028.

##QQ 群:
###362901808
##GitHub:
### https://github.com/FinalLody/Direct-Load-apk/
##Direct-Load-apk原理篇：
### http://my.oschina.net/u/2289564/blog/393252#OSC_h3_4
