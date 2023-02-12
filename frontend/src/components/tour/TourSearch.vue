<template>
    <section id="explore_area" class="section_padding">
        <div class="container">
            <!-- Section Heading -->
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="section_heading_center">
                        <h2>{{ resultCount }}명의 가이드</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3">
                    <div class="left_side_search_area">
                        <div class="left_side_search_boxed">
                            <div class="left_side_search_heading">
                                <h5>테마</h5>
                            </div>
                            <div class="tour_search_type" v-for="guidesTheme in resultThema" :key="guidesTheme">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" v-model="checkThema" :value="guidesTheme" :id="guidesTheme">
                                    <label class="form-check-label" :for="guidesTheme">
                                        <span class="area_flex_one">
                                            <span>{{ guidesTheme }}</span>
                                        </span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="left_side_search_boxed">
                            <div class="left_side_search_heading">
                                <h5>언어</h5>
                            </div>
                            <div class="tour_search_type">
                                <div class="form-check" v-for="guidesLang in resultLanguage" :key="guidesLang">
                                    <input class="form-check-input" type="checkbox" v-model="checkLanguage" :value="guidesLang" :id="guidesLang">
                                    <label class="form-check-label" :for="guidesLang">
                                        <span class="area_flex_one">
                                            <span>{{ guidesLang }}</span>
                                        </span>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="row">
                        <div v-for='tourInfo in resultGuide' :key="tourInfo.guideId" class="col-lg-4 col-md-6 col-sm-6 col-12">
                            <div class="theme_common_box_two img_hover">
                                <div class="theme_two_box_img">
                                    <router-link 
                                    :to="{
                                            name: 'hotel-details',
                                            params: { guideId: tourInfo.guideId  },
                                        }"
                                    >
                                        <img src="@/assets/img/tab-img/hotel1.png" onerror="this.onerror=null; this.src='@/assets/img/tab-img/hotel1.png';"/>
                                    </router-link>
                                    <p><i class="fas fa-map-marker-alt"></i>{{ tourInfo.country }}</p>
                                </div>
                                <div class="theme_two_box_content">
                                    <h4><router-link 
                                    :to="{
                                            name: 'hotel-details',
                                            params: { guideId: tourInfo.guideId  },
                                        }"
                                    >{{ tourInfo.name }}</router-link></h4>
                                    <p>
                                        <span class="review_rating">
                                            <span v-for="lang in tourInfo.language" :key="lang">#{{ lang }}</span>
                                        </span> 
                                        <span class="review_count">                                            
                                            <span v-for="theme in tourInfo.thema" :key="theme" >
                                                #{{ theme }}
                                            </span>                                            
                                        </span>
                                    </p>
                                    <h3>{{ tourInfo.introduction }} <span>{{ tourInfo.startForm }}</span></h3>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="pagination_area">
                                <ul class="pagination">
                                    <li class="page-item">
                                        <a class="page-link" href="#" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                            <span class="sr-only">Previous</span>
                                        </a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                        <a class="page-link" href="#" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                            <span class="sr-only">Next</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>
import Slider from '@vueform/slider'
import data from '../../data'
import { reactive, computed, ref, onMounted, watch } from 'vue'
import { useRoute } from "vue-router";
import { guideSearch } from "../../../common/api/commonAPI"


export default {
    name: "TourSearch",
    components: {
        Slider
    },

    data() {
        return {
            value: [0, 75],
            items: [],
        }
    },

    mounted() {
        this.items = data.tourData
        
    },

    setup(props, { emit }) {
        const route = useRoute()

        const resultArray = ref([])

        const resultGuide = ref([])

        const resultLanguage = ref([])

        const resultThema = ref([])

        const checkThema = ref([])

        const checkLanguage = ref([])

        const findSearch = async function (item) {
            try {
                const response = await guideSearch(item)
                console.log(response.data);
                resultArray.value = response.data
                resultGuide.value = resultArray.value
                let languageSet = new Set()
                let themaSet = new Set()

                for (let guide of resultArray.value) {
                    for (let lang of guide.language) {
                        languageSet.add(lang)
                    }
                    for (let them of guide.thema) {
                        themaSet.add(them)
                    }
                }
                console.log(languageSet, themaSet);
                resultLanguage.value = languageSet
                resultThema.value =themaSet

            } catch(error) {
                console.log(error);
            }
        }

        onMounted(() => {
            console.log(route.params.searchitem, '서치결과잇는곳');
            findSearch(route.params.searchitem)

        })


        const resultCount = computed(() => {
            return resultArray.value.length
        })

        watch (checkThema, (newVal, oldVal) => {
            if (checkThema.value.length == 0 && checkLanguage.value.length == 0) {
                resultGuide.value = resultArray.value
            } else {
                const sResult = resultArray.value.filter(function(guide) {
                    const check = guide.thema.filter(x => checkThema.value.includes(x))
                    const check2 = guide.language.filter(x => checkLanguage.value.includes(x))
                    
                    console.log(check);
                    return check.length + check2.length > 0
                })
                console.log(sResult)
                resultArray.value = sResult
            }
        })

        watch (checkLanguage, (newVal, oldVal) => {
            if (checkThema.value.length == 0 && checkLanguage.value.length == 0) {
                resultGuide.value = resultArray.value
            } else {
                const sResult = resultArray.value.filter(function(guide) {
                    const check = guide.thema.filter(x => checkThema.value.includes(x))
                    const check2 = guide.language.filter(x => checkLanguage.value.includes(x))
                    
                    console.log(check);
                    return check.length + check2.length > 0
                })
                console.log(sResult)
                resultArray.value = sResult
            }
        })

        return { findSearch, resultArray, resultCount, resultLanguage, resultThema, checkThema, checkLanguage, resultGuide }
    }

};
</script>
<style src="@vueform/slider/themes/default.css">

</style>