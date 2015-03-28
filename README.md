Direct-load-apk
===================
![enter image description here](http://www.xiaoxiongbizhi.com/wallpapers/1152_864_85/u/x/uxcccgx3r.jpg)
描述
-------------

Direct - load - apk 是一个强大的插件化框架, 通过使用它, 你可以实现看似不可能实现的功能 ----- **直接加载一个普通apk!** 

> **优势:** 
> - Direct - load - apk 能够加载插件的全部 **资源**. 
> - 支持 *插件间* Activity跳转. 
> - 不像 **"[dynamic load - apk](https://github.com/singwhatiwanna/dynamic-load-apk)"** 这个项目, [**"Direct - load - apk"**](https://github.com/asLody/Direct-load-apk) 不需要对插件有任何约束，也不需要在插件中引入jar和继承自定义Activity，可以直接使用this指针。
#### <i class="icon-folder-open"></i> 
###使用方法

Direct - load - apk 的使用相当方便，可以像这样写:

    PluginLaunch.startPlugin(Context,Path);

> **提示:** 不要忘了在 AndroidManifest.xml 加入 **com.lody.plugin.LActivityProxy** .

#### <i class="icon-pencil"></i> 开发**进度** 和 **未来将要做的**
> - 即将支持Service.
> -  即将支持运行带有.so的apk.
> - 提供完整的插件异常处理机制.

**作者**
-------------
     Lody, 一个富有开源精神和创造力的Android开发者。
如果你有任何问题 , 可以发送**Email** 到 *382816028@qq.com* , 也可以联系我的*QQ*:382816028.

##QQ 群:
###362901808