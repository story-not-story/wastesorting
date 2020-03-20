<template>
  <div class="header">
    <router-link tag="div" to="/" :class="['iconfont','icon',{'circle' : !showTitle}]">&#xe622;</router-link>
    <div class="title" :style="opacityStyle" v-show="showTitle">景点详情</div>
  </div>
</template>
<script>
export default {
  name: 'DetailHeader',
  data() {
    return {
      showTitle: false,
      opacityStyle: {
        opacity: 0
      }
    }
  },
  methods: {
    handleScroll() {
      const top = document.documentElement.scrollTop
      if (top > 60) {
        let opacity = top / 140
        this.opacityStyle.opacity = opacity > 1 ? 1 : opacity
        this.showTitle = true
      } else {
        this.showTitle = false
      }
    }
  },
  activated() {
    window.addEventListener('scroll', this.handleScroll)
  },
  deactivated() {
    window.removeEventListener('scroll', this.handleScroll)
  }
}
</script>
<style lang="stylus" scoped>
@import '~styles/variables.styl'
  .header
    height: .6rem
    position: fixed
    left: 0
    top: 0
    right: 0
    z-index: 1
    .circle
      background: rgba(0, 0, 0, .8)
      border-radius: .4rem
      padding: .08rem
    .icon
      color: #fff
      position: fixed
      left: .08rem
      top: .14rem
    .title
      background: $bgcolor
      text-align: center
      line-height: .6rem
</style>
