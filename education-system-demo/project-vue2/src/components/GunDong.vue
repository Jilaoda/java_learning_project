<template>

            <div>
                  <div class="image-slider">
                      <div class="slider-nav left" @click="previousImage">{{ der1 }}</div>
                      <div class="image-container">
                          <img :src="currentImage.src" alt="Slider Image" v-if="currentImage">
                      </div>
                      <div class="slider-nav right" @click="nextImage">{{ der2 }}</div>
                  </div>
                  <h1 class="slogan">教务管理平台</h1>
           </div>
</template>
<script type="text/javascript">
export default {
  data() {
      return {
          imgArr: [	// 图片数组
              { src: 'https://www.guet.edu.cn/_upload/article/images/3c/9d/95c5cd614c0bb5cafd016be00a2a/eb8fb0dd-366e-417d-9d6c-3c3e774c5de1.jpg' },
              { src: 'https://www.guet.edu.cn/_upload/article/images/2c/dd/780ee15b4e9280db72c2481d395f/4df0825e-587e-451e-9276-7f3da61a10e7.jpg' },
              { src: 'https://www.guet.edu.cn/_upload/article/images/85/99/01659eaf4285b72823f366762cf9/1de77efc-f735-47d4-9dc2-fb927510673b.jpg' },
              { src: 'https://www.guet.edu.cn/_upload/article/images/c2/27/715704dc41cda8ded12da74f253d/fe168f22-0cce-49bf-be05-6f9d96983e35.jpg' }
          ],
          currentIndex: 0,
          currentImage: null,
          der1: "<",
          der2: ">",
          userInfo: null
      }
  },


  mounted() {
      this.loadImages();
  },


  methods: {
       gotofind(){
      this.$router.push('/TestDemo');
    },
      gotoLogin(){
          this.$router.push('/in');
      },
      gotoRegister(){
          this.$router.push('/register');
      },
      loadImages() {
          const imagePromises = this.imgArr.map((imageObj) => {
              return new Promise((resolve, reject) => {
                  const image = new Image();
                  image.onload = () => resolve(imageObj);
                  image.onerror = reject;
                  image.src = imageObj.src;
              });
          });

          Promise.all(imagePromises)
              .then((images) => {
                  this.currentImage = images[this.currentIndex];
                  this.startSlideshow();
              })
              .catch((error) => {
                  console.error('Error loading images', error);
              });
      },
      startSlideshow() {
          setInterval(() => {
              this.nextImage();
          }, 3000);
      },
      nextImage() {
          this.currentIndex = (this.currentIndex + 1) % this.imgArr.length;
          this.currentImage = this.imgArr[this.currentIndex];
      },
      previousImage() {
          this.currentIndex = (this.currentIndex - 1 + this.imgArr.length) % this.imgArr.length;
          this.currentImage = this.imgArr[this.currentIndex];
      }
  }

}
</script>
<style>
.logo-text {
font-size: 18px;
font-weight: bold;
color: #fff;
padding-left: 10px;
border-left: 1px solid #fff;
}
.user-info-container {
  margin-right: 5px;
  display: flex;
  align-items: center;
}
.slogan {
  background: linear-gradient(to right, #ff00ff, #00ffff);
 -webkit-background-clip: text;
 -webkit-text-fill-color: transparent;
text-align: center;
font-size: 24px;
font-weight: bold;
color: #333333;
margin-top: 20px;
font-size: 36px;
font-weight: bold;
color: #333333;
text-align: center;
text-transform: uppercase;
text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}

.login-button,
.register-button {
  margin-right: 5px;
}

.image-slider {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
}

.slider-nav {
  position: absolute;
  top: 50%;
  font-size: 24px;
  color: #363131;
  cursor: pointer;
  user-select: none;
}

.left {
  color: aqua;
  left: 20px;
}

.right {
  color: aqua;
  right: 20px;
}

.slider-nav:hover {
  color: #ff0000;
}

.image-container {
  height :"1000px";
  display: flex;
  align-items: center;
  justify-content: center;
}

img {
  max-width: 100%;
  height: auto;
}
</style> 