<template>

    <section id="contact_main_arae" class="section_padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="section_heading_center">
                        <h2>Contact with us</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="phone_tuch_area">
                        <h3>Stay in touch</h3>
                        <h3><a href="tel:+00-123-456-789">+00 123 456 789</a></h3>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 col-12">
                    <div class="contact_boxed">
                        <h6>Head office</h6>
                        <h3>New Mexico</h3>
                        <p>4140 Parker Rd. Allentown, New Mexico 31134</p>
                        <a href="#" @click="modalToggle">View on map</a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 col-12">
                    <div class="contact_boxed">
                        <h6>Washington office</h6>
                        <h3>Washington</h3>
                        <p>4517 Washington Ave. Manchester, Kentucky 39495</p>
                        <a href="#" @click="modalToggle">View on map</a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 col-12">
                    <div class="contact_boxed">
                        <h6>California office</h6>
                        <h3>California</h3>
                        <p>3891 Ranchview Dr. Richardson, California 62639</p>
                        <a href="#" @click="modalToggle">View on map</a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 col-12">
                    <div class="contact_boxed">
                        <h6>Office schedule</h6>
                        <h3>Working hours</h3>
                        <p>Monday to Friday <br /> 9 am to 10pm</p>
                        <a href="#" @click="modalToggle">View on map</a>
                    </div>
                </div>
            </div>

            <div ref="modal" class="modal fade" :class="{ show: active, 'd-block': active }" tabindex="-1"
                role="dialog">
                <div class="modal-dialog modal-dialog-centered  modal-lg">
                    <div class="modal-content">
                        <div class="modal-body map_modal_content">
                            <div class="btn_modal_closed">
                                <button type="button" data-bs-dismiss="modal" aria-label="Close" @click="modalToggle"><i
                                        class="fas fa-times"></i></button>
                            </div>
                            <div class="map_area">
                                <iframe
                                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3677.6962663570607!2d89.56355961427838!3d22.813715829827952!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39ff901efac79b59%3A0x5be01a1bc0dc7eba!2sAnd+IT!5e0!3m2!1sen!2sbd!4v1557901943656!5m2!1sen!2sbd"></iframe>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="contact_main_form_area">
                <div class="row">
                    <div class="col-lg-8 offset-lg-2">
                        <div class="section_heading_center">
                            <h2>Leave us a message</h2>
                        </div>
                        <div class="contact_form">
                            <form action="!#" id="contact_form_content">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control bg_input" placeholder="First name*">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control bg_input" placeholder="Last name*">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control bg_input"
                                                placeholder="Email address (Optional)">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control bg_input"
                                                placeholder="Mobile number*">
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <textarea class="form-control bg_input" rows="5"
                                                placeholder="Message"></textarea>
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <button type="button" class="btn btn_theme btn_md">Send message</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>

<script>

export default {
    name: "ContactArea",
    data() {
        return {
            active: false,
        }
    },
    methods: {
        modalToggle() {
            const body = document.querySelector("body")
            this.active = !this.active
            this.active ? body.classList.add("modal-open") : body.classList.remove("modal-open")
        },
    },
};
</script>