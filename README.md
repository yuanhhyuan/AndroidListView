# UI3

一、ListView

1、Listview使用

（1）、定义列表内容，且定义其对应的类。

/res/layout/item_listview.xml
      对应类ListviewItemBean
      
（2）、定义其对应的适配器ItemAdapter1，这里是采用优化性能的方式（这部分放后面探讨）。
（3）、定义listview对应的布局，创建适配器示例，将适配器绑定到布局。
（4）、监听用户点击事件并处理。

2、Listview优化
1、优化一：对view对象的复用做的优化
  listivew每次滚动都会调用gitview()方法，所以优化gitview是重中之重。也是最普通的优化，就在MyAdapter类(ItemAdapter)中的getView方法中，我们注意到，上面的写法每次需要一个View对象时，都是去重新inflate一个View出来返回去， 没有实现View对象的复用，而实际上对于ListView而言，只需要保留能够显示的最大个数的view即可，其他新的view可以通过复用的方式使用消失的条目的view，
  而getView方法里也提供了一个参数：convertView，这个就代表着可以复用的view对象，当然这个对象也可能为空，当它为空的时候，表示该条目view第一次创建，
  所以我们需要inflate一个view出来,我们使用下面这种方式来重写getView(ItemAdapter1)方法：
      @NonNull
      @Override
      public View getView(final int position, View convertView, ViewGroup parent) {
          Log.d(tag, "ItemAdapter1 getView called, position: " + position + ", convertView: " + convertView);
          View view;
          ViewHolder viewHolder;
          ListviewItemBean item1 = getItem(position);
          if (convertView == null) {
              view = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);
              viewHolder = new ViewHolder();
              viewHolder.imageView = (ImageView) view.findViewById(R.id.item_img);
              viewHolder.textView = (TextView) view.findViewById(R.id.item_text);
              viewHolder.mButton = (Button) view.findViewById(R.id.item_button);
              view.setTag(viewHolder); // 通过setTag将ViewHolder和convertView绑定
          } else {
              view = convertView;
              viewHolder = (ViewHolder) view.getTag();
          }
          ......
          return view;
      }

2、优化二：ViewHolder绑定对应的id，不用每次到xml文件中去查找对应的id。
在convertView为null的时候，我们不仅重新inflate出来一个view，并且还需要进行findviewbyId的查找工作，但是同时我们还需要获取一个ViewHolder类的对象，并将findviewById的结果赋值给ViewHolder中对应的成员变量。最后将holder对象与该view对象“绑”在一块。

可以看到方案一二目的很明确：第一个是优化加载布局，第二个是优化加载控件。

------------------------------------------------------------------------------------

有没有想过ListView加载成千上万的数据为什么不出OOM错误？
最主要的是因为RecycleBin机制。
listview的许多view呈现在Ui上，这样的View对我们来说是可见的，可以称为OnScreen的view(也为ActionView)。
view被上滚移除屏幕，这样的view称为offScreenView（也称为ScrapView）。
然后ScrapView会被listview删除，而RecycleView会将这部分保存。
而listview底部需要显示的view会从RecycleBin里面取出一个ScrapView。

博客地址：https://mp.csdn.net/postedit/80760012


二、Scrollview

博客地址：https://mp.csdn.net/postedit/80764411

三、Recyclerview

博客地址：https://mp.csdn.net/postedit/80762358


四、SuperSwipeRefreshLayout 下拉刷新，上拉加载

//三方库
compile 'com.github.nuptboyzhb.lib.uikit:superswiperefreshlayout:1.0.0'

给出了使用案例。

五、Gridview
