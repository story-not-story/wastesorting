<template>
  <div class="gallery" @click="handleClose">
    <div class="wrapper">
      <swiper :options="swiperOption">
      <!-- slides -->
        <swiper-slide v-for="(item,index) in imgs" :key="index">
          <img class="swiper-img" :src="item"/>
        </swiper-slide>
        <!-- Optional controls -->
        <div class="swiper-pagination"  slot="pagination"></div>
      </swiper>
    </div>
  </div>
</template>
<script>
export default{
  name: 'CommonGallery',
  props: {
    imgs: {
      type: Array,
      default() {
        return []
      }
    }
  },
  data() {
    return {
      swiperOption: {
        pagination: '.swiper-pagination',
        paginationType: 'fraction',
        loop: true,
        observer: true,
        observeParents: true
      }
    }
  },
  methods: {
    handleClose() {
      this.$emit('change')
    }
  }
}
</script>
<style lang="stylus" scoped>
  .gallery >>> .swiper-container
    overflow: inherit
  .gallery
    position: fixed
    top: 0
    right: 0
    bottom: 0
    left: 0
    background: #000
    display: flex
    align-items: center
    z-index: 1
    .wrapper
      width: 100%
      height: 0
      padding-bottom: 100%
      .swiper-pagination
        color: red
        margin-bottom: -1rem
      .swiper-img
        width: 100%
</style>
