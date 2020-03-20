<template>
  <div class="list">
    <div v-for="(item,index) in list" :key="index" class="border-bottom"><span class="icon"></span>{{item.title}}
      <detail-list v-if="item.children" :list="item.children"></detail-list>
    </div>
  </div>
</template>
<script>
export default {
  name: 'DetailList',
  props: {
    list: Array
  }
}
</script>
<style lang="stylus" scoped>
@import '~styles/variables.styl'
  .list
    padding: 0 $pl
    line-height: .8rem
    font-size: .32rem
    .icon
      position: relative
      right: -.1rem
      bottom: -.1rem
      display: inline-block
      width: .36rem
      height: .36rem
      background: url(http://s.qunarzz.com/piao/image/touch/sight/detail.png) 0 -.45rem no-repeat
      margin-right: .1rem
      background-size: .4rem 3rem
</style>
