<template>
  <div class="alphabet">
    <ul class="list">
      <li class="item" v-for="item in letters" v-text="item" :key="item" @touchstart="handleTouchStart" @touchmove="handleTouchMove" @touchend="handleTouchEnd" @click="handleLetterClick" :ref="item"></li>
    </ul>
  </div>
</template>
<script>
export default{
  name: 'CityAlphabet',
  data() {
    return {
      touchStatus: false,
      startY: 0,
      timer: null
    }
  },
  props: {
    city: Object
  },
  updated() {
    this.startY = this.$refs['A'][0].offsetTop
  },
  computed: {
    letters() {
      const letters = []
      for (let i in this.city) {
        letters.push(i)
      }
      return letters
    }
  },
  methods: {
    handleLetterClick(e) {
      this.$emit('change', e.target.innerText)
    },
    handleTouchStart() {
      this.touchStatus = true
    },
    handleTouchMove(e) {
      if (this.touchStatus) {
        if (this.timer) {
          clearTimeout(this.timer)
        }
        this.timer = setTimeout(() => {
          const touchY = e.touches[0].clientY - 86
          const index = Math.floor((touchY - this.startY) / 20)
          if (index >= 0 && index < this.letters.length) {
            this.$emit('change', this.letters[index])
          }
        }, 16)
      }
    },
    handleTouchEnd() {
      this.touchStatus = false
    }
  }
}
</script>
<style lang="stylus" scoped>
@import '~styles/variables.styl'
  .list
    position: absolute
    display: flex
    flex-direction: column
    justify-content: center
    top: 1.72rem
    right: 0
    bottom: 0
    width: .4rem
    .item
      line-height: .4rem
      text-align: center
      color: $bgcolor
</style>
