<template>
  <div class="header">
    <div class="header-left">
      <div class="iconfont back-icon">&#xe622;</div>
    </div>
    <div class="header-input">
      <span class="iconfont search-icon">&#xe8b9;</span>input
    </div>
    <div class="header-right">
      {{this.city}}<span class="iconfont arrow-icon">&#xe6aa;</span>
    </div>
  </div>
</template>
<script>
export default{
  name: 'Header',
  props: {
    city: String
  }
}
</script>
<style lang="stylus" scoped>
@import '~styles/variables.styl'
  .header
    display: flex
    line-heigth: .86rem
    background: $bgcolor
    color: #fff
    magin: 0
    .header-left
      width: .64rem
      float: left
      .back-icon
        margin-left: .15rem
        margin-top: .18rem
        text-align: center
        font-size: .4rem
    .header-input
      flex: 1
      height: .64rem
      line-heigth: .64rem
      margin-top: .12rem
      margin-left: .2rem
      padding-left: .2rem
      padding-top: 0.16rem
      background: #fff
      color: #ccc
      border-radius: .1rem
    .header-right
      width: 1.24rem
      float: right
      text-align: center
      padding-top: 0.25rem
      .arrow-icon
        margin-left: -.04rem
        font-size: .24rem
</style>
