<template>
    <section id="destinations_area" class="section_padding_top">
        <div class="container">
            <!-- Section Heading -->
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="section_heading_center">
                        <h2>Destinations for you</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-10 offset-lg-1">
                    <div class="theme_nav_tab">
                        <nav class="theme_nav_tab_item">
                            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                <button class="nav-link active" id="nav-nepal-tab" data-bs-toggle="tab"
                                    data-bs-target="#nav-nepal" type="button" role="tab" aria-controls="nav-nepal"
                                    aria-selected="true">Nepal</button>
                                <button class="nav-link" id="nav-malaysia-tab" data-bs-toggle="tab"
                                    data-bs-target="#nav-malaysia" type="button" role="tab" aria-controls="nav-malaysia"
                                    aria-selected="false">Malaysia</button>
                                <button class="nav-link" id="nav-indonesia-tab" data-bs-toggle="tab"
                                    data-bs-target="#nav-indonesia" type="button" role="tab"
                                    aria-controls="nav-indonesia" aria-selected="false">Indonesia</button>
                                <button class="nav-link" id="nav-turkey-tab" data-bs-toggle="tab"
                                    data-bs-target="#nav-turkey" type="button" role="tab" aria-controls="nav-turkey"
                                    aria-selected="false">Turkey</button>
                                <button class="nav-link" id="nav-china-tab" data-bs-toggle="tab"
                                    data-bs-target="#nav-china" type="button" role="tab" aria-controls="nav-china"
                                    aria-selected="false">China</button>
                                <button class="nav-link" id="nav-darjeeling-tab" data-bs-toggle="tab"
                                    data-bs-target="#nav-darjeeling" type="button" role="tab"
                                    aria-controls="nav-darjeeling" aria-selected="false">Darjeeling</button>
                                <button class="nav-link" id="nav-italy-tab" data-bs-toggle="tab"
                                    data-bs-target="#nav-italy" type="button" role="tab" aria-controls="nav-italy"
                                    aria-selected="false">Italy</button>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="tab-content" id="nav-tabContent1">
                        <div class="tab-pane fade show active" id="nav-nepal" role="tabpanel"
                            aria-labelledby="nav-nepal-tab">
                            <div class="row">
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small1.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Everest trek to Base Camp</router-link></h3>
                                            <p>Price starts at <span>$105.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small2.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Kathmundu tour</router-link></h3>
                                            <p>Price starts at <span>$85.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small3.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Beautiful pokhara</router-link></h3>
                                            <p>Price starts at <span>$100.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small4.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Annapurna region</router-link></h3>
                                            <p>Price starts at <span>$75.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small5.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Chitwan national park</router-link></h3>
                                            <p>Price starts at <span>$105.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small6.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Langtang region</router-link></h3>
                                            <p>Price starts at <span>$105.00</span></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="nav-malaysia" role="tabpanel" aria-labelledby="nav-malaysia-tab">
                            <div class="row">
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small2.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Kathmundu tour</router-link></h3>
                                            <p>Price starts at <span>$85.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small3.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Beautiful pokhara</router-link></h3>
                                            <p>Price starts at <span>$100.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations">
                                                <img src="../../assets/img/destination/destination-small4.png" alt="img">
                                            </router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Annapurna region</router-link></h3>
                                            <p>Price starts at <span>$75.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small6.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Langtang region</router-link></h3>
                                            <p>Price starts at <span>$105.00</span></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="nav-indonesia" role="tabpanel"
                            aria-labelledby="nav-indonesia-tab">
                            <div class="row">
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small3.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Beautiful pokhara</router-link></h3>
                                            <p>Price starts at <span>$100.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small4.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Annapurna region</router-link></h3>
                                            <p>Price starts at <span>$75.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small6.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Langtang region</router-link></h3>
                                            <p>Price starts at <span>$105.00</span></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="nav-turkey" role="tabpanel" aria-labelledby="nav-turkey-tab">
                            <div class="row">
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small2.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Kathmundu tour</router-link></h3>
                                            <p>Price starts at <span>$85.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small3.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Beautiful pokhara</router-link></h3>
                                            <p>Price starts at <span>$100.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small4.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Annapurna region</router-link></h3>
                                            <p>Price starts at <span>$75.00</span></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="nav-china" role="tabpanel" aria-labelledby="nav-china-tab">
                            <div class="row">
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small4.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Annapurna region</router-link></h3>
                                            <p>Price starts at <span>$75.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small6.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Langtang region</router-link></h3>
                                            <p>Price starts at <span>$105.00</span></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="nav-darjeeling" role="tabpanel"
                            aria-labelledby="nav-darjeeling-tab">
                            <div class="row">
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small4.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Annapurna region</router-link></h3>
                                            <p>Price starts at <span>$75.00</span></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="nav-italy" role="tabpanel" aria-labelledby="nav-italy-tab">
                            <div class="row">
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small4.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Annapurna region</router-link></h3>
                                            <p>Price starts at <span>$75.00</span></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="tab_destinations_boxed">
                                        <div class="tab_destinations_img">
                                            <router-link to="/top-destinations"><img
                                                    src="../../assets/img/destination/destination-small6.png" alt="img"></router-link>
                                        </div>
                                        <div class="tab_destinations_conntent">
                                            <h3><router-link to="/top-destinations">Langtang region</router-link></h3>
                                            <p>Price starts at <span>$105.00</span></p>
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
    name: "Destinations"
};
</script>