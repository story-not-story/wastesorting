<template>
  <div class="list" ref="wrapper">
    <div class="content">
      <div class="area">
        <div class="title border-topbottom">当前城市</div>
        <div class="btnlist">
          <button class="btn">{{this.cityname}}</button>
        </div>
      </div>
      <div class="area">
        <div class="title border-topbottom">热门城市</div>
        <div class="btnlist">
          <button class="btn" @click="handleClick(item.name)" v-for="item in hotcity" :key="item.id" v-text="item.name"></button>
        </div>
      </div>
      <div class="area" v-for="(value,name) in city" :key="name" :ref="name">
        <div class="title border-topbottom" v-text="name"></div>
        <ul class="itemlist">
          <li class="item border-bottom" @click="handleClick(city.name)" v-for="city in value" v-text="city.name" :key="city.id"></li>
        </ul>
      </div>
    </div>
  </div>
</template>
<script>
import BScroll from 'better-scroll'
import { mapState, mapMutations } from 'vuex'
export default{
  name: 'CityList',
  props: {
    hotcity: Array,
    city: Object,
    letter: String
  },
  computed: {
    ...mapState({
      cityname: 'city'
    })
  },
  methods: {
    handleClick(city) {
      this.changeCity(city)
      this.$router.push('/')
    },
    ...mapMutations(['changeCity'])
  },
  mounted() {
    this.$nextTick(() => {
      if (!this.scroll) {
        this.scroll = new BScroll(this.$refs.wrapper, {
          click: true
        })
      } else if (this.$refs.wrapper) {
        this.scroll.refresh()
      }
    })
  },
  watch: {
    letter() {
      if (this.letter) {
        const area = this.$refs[this.letter][0]
        this.scroll.scrollToElement(area)
      }
    }
  }
}
</script>
<style lang="stylus" scoped>
@import '~styles/variables.styl'
  .border-topbottom
    &:before
      border-color: #ccc
    &:after
      border-color: #ccc
  .border-bottom
    &:before
      border-color: #ccc
  .list
    position: absolute
    overflow: hidden
    top: 1.7rem
    right: 0
    bottom: 0
    left: 0
    .title
      background: #eee
      padding-left: .2rem
      line-height: .44rem
      color: #666
      font-size: .26rem
    .btnlist
      overflow: hidden
      padding: .1rem .6rem .1rem .1rem
      .btn
        float: left
        width: 30%
        border-radius: $radius
        border: .02rem solid #777
        background: #fff
        padding: .1rem 0
        text-align: center
        margin: .1rem
    .itemlist
      .item
        line-height: $height
        padding-left: $pl
</style>
