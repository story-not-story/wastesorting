<template>
  <div>
    <div class="search">
      <input type="text" v-model.lazy="searchcity" name="city" class="input-city" placeholder="搜索城市" />
    </div>
    <div class="search-content" ref="search" v-show="searchcity">
      <ul class="itemlist">
        <li class="item border-bottom" v-for="item in list" v-text="item.name" :key="item.id" @click="handleClick(item.name)"></li>
        <li class="item border-bottom" v-show="hasdata">没有找到匹配数据</li>
      </ul>
    </div>
  </div>
</template>
<script>
import BScroll from 'better-scroll'
import { mapMutations } from 'vuex'
export default{
  name: 'CitySearch',
  props: {
    city: Object
  },
  data() {
    return {
      searchcity: '',
      list: []
    }
  },
  methods: {
    handleClick(city) {
      this.changeCity(city)
      this.$router.push('/')
    },
    ...mapMutations(['changeCity'])
  },
  computed: {
    hasdata() {
      return !this.list.length
    }
  },
  mounted() {
    this.$nextTick(() => {
      if (!this.scroll) {
        this.scroll = new BScroll(this.$refs.search, {
          click: true
        })
      } else if (this.$refs.search) {
        this.scroll.refresh()
      }
    })
  },
  watch: {
    searchcity() {
      const result = []
      for (let i in this.city) {
        this.city[i].forEach((o) => {
          const cityname = this.searchcity.trim()
          if (o.name.indexOf(cityname) > -1 ||
            o.spell.indexOf(cityname) > -1) {
            result.push(o)
          }
        })
      }
      this.list = result
    }
  }
}
</script>
<style lang="stylus" scoped>
@import '~styles/variables.styl'
  .border-bottom
    &:before
      border-color: #ccc
  .search
    height: $height
    line-heigth: $height
    background: $bgcolor
    text-align: center
    .input-city
      width: 97%
      height: 80%
      box-sizing: border-box
      padding: 0 0.1rem
      color: #ccc
      border-radius: $radius
      text-align: center
  .search-content
    background: #fff
    position: absolute
    overflow: hidden
    top: 1.7rem
    right: 0
    bottom: 0
    left: 0
    z-index: 1
    .itemlist
      .item
        line-height: $height
        padding-left: $pl
        color: #ccc
</style>
