<template>
  <div id="app">
  <!-- 当前路径所对应的页面 -->
    <keep-alive exclude="Detail">
      <router-view/>
    </keep-alive>
  </div>
</template>
<script>
export default {
  name: 'App'
}
</script>
<style></style>
