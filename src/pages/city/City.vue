<template>
  <div>
    <city-header></city-header>
    <city-search :city="cities"></city-search>
    <city-list :hotcity="hotCities" :city="cities" :letter="letter"></city-list>
    <city-alphabet :city="cities" @change="handleLetterChange"></city-alphabet>
  </div>
</template>
<script>
import CityHeader from './components/Header'
import CitySearch from './components/Search'
import CityList from './components/List'
import CityAlphabet from './components/Alphabet'
import axios from 'axios'
export default {
  name: 'City',
  components: {
    CityHeader,
    CitySearch,
    CityList,
    CityAlphabet
  },
  data() {
    return {
      hotCities: [],
      cities: {},
      letter: ''
    }
  },
  methods: {
    getCityInfo() {
      axios.get('/api/city.json').then(this.getCityInfoSuc)
    },
    getCityInfoSuc(res) {
      res = res.data
      if (res.ret && res.data) {
        const data = res.data
        this.hotCities = data.hotCities
        this.cities = data.cities
      }
    },
    handleLetterChange(letter) {
      this.letter = letter
    }
  },
  mounted() {
    this.getCityInfo()
  }
}
</script>
<style lang="stylus" scoped></style>
