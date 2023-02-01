<template>
    <section id="common_banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="common_bannner_text">
                        <h2>Wallet</h2>
                        <ul>
                            <li><router-link to="/index">Home</router-link></li>
                            <li><span><i class="fas fa-circle"></i></span><router-link to="/dashboard">Customer
                                    dashboard</router-link></li>
                            <li><span><i class="fas fa-circle"></i></span>Wallet</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>

export default {
    name: "WalletBanner"
};
</script>