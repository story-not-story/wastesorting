<template>
  <div>
    <div class="title">周末去哪儿</div>
    <ul>
      <li v-for="item in list" :key="item.id">
        <div class="img-wrapper">
          <img class="img-content" :src="item.imgUrl"/>
        </div>
        <div class="img-info">
          <p class="img-title" v-text="item.title"></p>
          <p class="img-desc" v-text="item.desc"></p>
        </div>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  name: 'HomeWeekend',
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
    width: 100%
    height: 0
    padding-bottom: 35%
    overflow: hidden
    .img-content
      width: 100%
      background: #ccc
  .img-info
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
</style>
