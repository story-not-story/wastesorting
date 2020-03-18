<template>
  <div class="icons">
    <swiper>
    <!-- slides -->
      <swiper-slide v-for="(page,index) in pages" :key="index">
        <div class="icon" v-for="item in page" :key="item.id">
          <img class="img-content" :src="item.imgUrl"/>
          <p class="img-desc">热门景点热门景点热门景点热门景点热门景点热门景点</p>
        </div>
      </swiper-slide>
      <!-- Optional controls -->
      <div class="swiper-pagination"  slot="pagination"></div>
    </swiper>
  </div>
</template>
<script>
export default {
  name: 'HomeIcons',
  data() {
    return {
      iconList: [{
        id: '001',
        imgUrl: require('@/assets/img/landscape.png')
      }, {
        id: '002',
        imgUrl: require('@/assets/img/landscape.png')
      }, {
        id: '003',
        imgUrl: require('@/assets/img/landscape.png')
      }, {
        id: '004',
        imgUrl: require('@/assets/img/landscape.png')
      }, {
        id: '005',
        imgUrl: require('@/assets/img/landscape.png')
      }, {
        id: '006',
        imgUrl: require('@/assets/img/landscape.png')
      }, {
        id: '007',
        imgUrl: require('@/assets/img/landscape.png')
      }, {
        id: '008',
        imgUrl: require('@/assets/img/landscape.png')
      }, {
        id: '009',
        imgUrl: require('@/assets/img/landscape.png')
      }]
    }
  },
  computed: {
    pages() {
      const pages = []
      this.iconList.forEach((item, index) => {
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
  .icons >>> .swiper-container
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
