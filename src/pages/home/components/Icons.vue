<template>
  <div class="icons">
    <swiper :options="swiperOption">
    <!-- slides -->
      <swiper-slide v-for="(page,index) in pages" :key="index">
        <div class="icon" v-for="item in page" :key="item.id">
          <img class="img-content" :src="item.imgUrl"/>
          <p class="img-desc" v-text="item.desc"></p>
        </div>
      </swiper-slide>
    </swiper>
  </div>
</template>
<script>
export default {
  name: 'HomeIcons',
  props: {
    list: Array
  },
  data() {
    return {
      swiperOption: {
        autoplay: false
      }
    }
  },
  computed: {
    pages() {
      const pages = []
      this.list.forEach((item, index) => {
        const page = Math.floor(index / 8)
        if (!pages[page]) {
          pages[page] = []
        }
        pages[page].push(item)
      })
      return pages
    }
  }
}
</script>
<style lang="stylus" scoped>
@import '~styles/mixins.styl'
@import '~styles/variables.styl'
  .icons >>> .swiper-slide
    width: 100%
    height: 0
    padding-bottom: 50%
  .icons
    margin-top: .1rem
    .icon
      width: 25%
      height: 0
      padding-bottom: 25%
      float: left
      overflow: hidden
      position: relative
      .img-content
        width: 80%
        position: absolute
        top: 0
        right: 0
        bottom: 0.02rem
        left: 0
        margin: 0 auto
      .img-desc
        text-align: center
        position: absolute
        right: 0
        bottom: 0
        left: 0
        line-height: .4rem
        ellipsis()
</style>
