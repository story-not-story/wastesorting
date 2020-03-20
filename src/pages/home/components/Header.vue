<template>
  <div class="header">
    <div class="header-left">
      <div class="iconfont back-icon">&#xe622;</div>
    </div>
    <div class="header-input">
      <span class="iconfont search-icon">&#xe8b9;</span>input
    </div>
    <router-link to="/city">
      <div class="header-right">
        {{this.cityname}}<span class="iconfont arrow-icon">&#xe6aa;</span>
      </div>
    </router-link>
  </div>
</template>
<script>
import { mapState } from 'vuex'
export default{
  name: 'Header',
  computed: {
    ...mapState({
      cityname: 'city'
    })
  }
}
</script>
<style lang="stylus" scoped>
@import '~styles/variables.styl'
  .header
    display: flex
    align-items: center
    line-heigth: $height
    background: $bgcolor
    color: #fff
    magin: 0
    .header-left
      width: .64rem
      float: left
      .back-icon
        margin-left: .15rem
        text-align: center
        font-size: .4rem
    .header-input
      flex: 1
      height: .64rem
      line-heigth: .64rem
      margin-top: .12rem
      margin-left: .2rem
      padding-left: $pl
      padding-top: 0.16rem
      background: #fff
      color: #ccc
      border-radius: $radius
    .header-right
      width: 1.24rem
      float: right
      text-align: center
      color: #fff
      .arrow-icon
        margin-left: -.04rem
        font-size: .24rem
</style>
