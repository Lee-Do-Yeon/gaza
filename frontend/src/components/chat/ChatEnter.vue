<template>
    <div>
        <h1>채팅방 목록</h1>
        <form v-on:submit="makeRoom">
            <input name="title" v-model="roomTitle">
            <button class="send" type="submit">보내기</button>
        </form>
        <ul>
            <li><a href="/chat/rooms/{{roomId}}"></a></li>
        </ul>

    </div>
</template>
