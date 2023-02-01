<template>
    <section id="video_area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="video_area_vendor">
                        <img src="../../assets/img/common/video.png" alt="img">
                        <div class="video_play_button">
                            <a class="video_btn video_play_area" title="Youtube Video" @click="modalToggle"
                                data-bs-toggle="modal" data-bs-target="#myModal" href="#!"><i
                                    class="fas fa-play"></i></a>
                            <h4>{{ exploreInfo }}</h4>
                            <h2>{{ subTitle }}</h2>
                        </div>
                        <div ref="modal" class="modal fade" :class="{ show: active, 'd-block': active }" tabindex="-1"
                            role="dialog">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-body logout_modal_content">
                                        <div class="btn_modal_closed">
                                            <button type="button" data-bs-dismiss="modal" @click="modalToggle"
                                                aria-label="Close"><i class="fas fa-times"></i></button>
                                        </div>
                                        <div id="yt-player">
                                            <iframe width="100%" height="315"
                                                src="https://www.youtube.com/embed/rrT6v5sOwJg" frameborder="0"
                                                allowfullscreen></iframe>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>

export default {
    name: "Video",
    data() {
        return {
            exploreInfo:'Explore amazing tours',
            subTitle: 'Get some travel idea',
            active: false,
        }
    },
    methods: {
        modalToggle() {
            const body = document.querySelector("body")
            this.active = !this.active
            this.active ? body.classList.add("modal-open") : body.classList.remove("modal-open")

            var videos = document.querySelectorAll('iframe, video');
            Array.prototype.forEach.call(videos, function (video) {
                if (video.tagName.toLowerCase() === 'video') {
                    video.pause();
                } else {
                    var src = video.src;
                    video.src = src;
                }
            });

        },
    },
};
</script>