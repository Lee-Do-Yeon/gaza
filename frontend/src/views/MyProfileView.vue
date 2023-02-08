<template>

    <!-- Common Banner Area -->
    <!-- <MyProfileBanner /> -->

    <!-- Dashboard Area -->
    <ProfileDashboard />


</template>
<script>

// import MyProfileBanner from '@/components/dashboard/MyProfileBanner.vue'
import ProfileDashboard from '@/components/dashboard/ProfileDashboard.vue'

export default {
    name: "MyProfileView",
    components: {
        ProfileDashboard
    }
};
</script>
