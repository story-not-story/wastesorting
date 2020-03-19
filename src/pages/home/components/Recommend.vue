<template>
  <div>
    <div class="title">热门推荐</div>
    <ul>
      <li class="img-wrapper" v-for="item in list" :key="item.id">
        <img class="img-content" :src="item.imgUrl"/>
        <div class="img-info">
          <p class="img-title" v-text="item.title"></p>
          <p class="img-desc" v-text="item.desc"></p>
          <button class="btn">查看详情</button>
        </div>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  name: 'HomeRecommend',
  props: {
    list: Array
  }
}
</script>
<style lang="stylus" scoped>
@import '~styles/mixins.styl'
  .title
    margin-top: .2rem
    line-height: .8rem
    text-indent: .2rem
    background: #eee
  .img-wrapper
    height: 2rem
    display: flex
    overflow: hidden
    .img-content
      width: 1.7rem
      height: 1.7rem
      padding: .15rem
    .img-info
      flex: 1
      padding: .15rem
      min-width: 0
      .img-title
        font-size: .32rem
        line-height: .54rem
        ellipsis()
      .img-desc
        line-height: .3rem
        color: #ccc
        ellipsis()
      .btn
        line-height: .44rem
        margin-top: .2rem
        background: #ff9300
        padding: 0 0.15rem
        border-radius: $radius
</style>
