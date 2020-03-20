<template>
  <div>
    <div class="banner">
      <div class="img" @click="handleClick">
        <img :src="bannerImg"/>
      </div>
      <div class="img-info">
        <div class="img-title" v-text="sightName"></div>
        <div class="iconfont img-icon">&#xe662;{{gallaryImgs.length}}</div>
      </div>
    </div>
    <common-fade>
      <common-gallery :imgs="gallaryImgs" v-show="showGallery" @change="handleGalleryClose"></common-gallery>
    </common-fade>
  </div>
</template>
<script>
import CommonGallery from 'common/gallery/Gallery'
import CommonFade from 'common/fade/Fade'
export default{
  name: 'DetailBanner',
  props: {
    sightName: String,
    bannerImg: String,
    gallaryImgs: Array
  },
  data() {
    return {
      imgs: ['/static/img/yandangshan.jpeg', 'static/img/putuoshan.jpeg'],
      showGallery: false
    }
  },
  components: {
    CommonGallery,
    CommonFade
  },
  methods: {
    handleClick() {
      this.showGallery = true
    },
    handleGalleryClose() {
      this.showGallery = false
    }
  }
}
</script>
<style lang="stylus" scoped>
@import '~styles/variables.styl'
  .banner
    overflow: hidden
    width: 100%
    height: 0
    padding-bottom: 55%
    position: relative
    .img
      width: 100%
    .img-info
      position: absolute
      bottom: 0
      left: 0
      right: 0
      display: flex
      align-items: center
      background-image: linear-gradient(top, rgba(0, 0, 0, 0), rgba(0, 0, 0, .8))
      .img-title
        flex: 1
        line-height: $height
        font-size: .4rem
        padding-left: $pl
        color: #fff
      .img-icon
        float: right
        padding-right: .4rem
        color: #fff
</style>
