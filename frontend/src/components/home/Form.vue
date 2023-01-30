<template>
    <section id="theme_search_form">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="theme_search_form_area">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="tours" role="tabpanel" aria-labelledby="tours-tab">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="tour_search_form">
                                            <form action="#!">
                                                <div class="row">
                                                    <div class="col-lg-10 col-md-12 col-sm-12 col-12 flight_Search_boxed d-flex">
                                                        <img src="../../assets/img/icon/Icon.png" class="d-inline m-auto pe-2" alt="">
                                                        <input type="text" class="d-inline" placeholder="Where are you going?">
                                                    </div>
                                                    <div class="top_form_search_button col-lg-2 col-md-12 col-sm-12 col-12">
                                                        <button class="btn btn_theme btn_md">Search</button>
                                                    </div>
                                                </div>
                                            </form>
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
    name: "Form",
    data() {
        return {
            isHidden: false,
            rowData: [{ name: '' }]
        };
    },
    methods: {
        addRow: function () {

            let a = Math.random().toString(36).replace(/[^a-z]+/g, '').substr(0, 5);

            if (document.querySelectorAll('.multi_city_form').length === 5) {
                alert("Max Citry Limit Reached!!")
                return;
            }

            this.isHidden = true

            this.rowData.push({ name: '' })
        },
        deleteRow(index) {
            this.rowData.splice(index, 1);
        }

    }
};
</script>