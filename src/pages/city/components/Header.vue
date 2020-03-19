<template>
  <div class="header">
    <router-link to="/">
      <div class="iconfont back-icon">&#xe622;</div>
    </router-link>
    <div class="title">城市</div>
  </div>
</template>
<script>
export default{
  name: 'CityHeader'
}
</script>
<style lang="stylus" scoped>
@import '~styles/variables.styl'
  .header
    display: flex
    align-items: center
    height: $height
    line-heigth: $height
    background: $bgcolor
    color: #fff
    magin: 0
    text-align: center
    .back-icon
      float: left
      font-size: .4rem
      color: #fff
    .title
      flex: 1
      font-size: .6rem
</style>
