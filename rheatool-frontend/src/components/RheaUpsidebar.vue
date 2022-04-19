<template>
    <header>
        <h3>{{title}}</h3>
        <button @click="TogglePopup()">Create new {{element}}</button>
    </header>
</template>

<script>
export default {
    name: 'rhea-upsidebar',
    props: {
        title: String,
        element: String
    },
    methods: {
        TogglePopup() {
            this.$emit("togglePopup");
        }
    }
}
</script>

<style lang="scss" scoped>
header {
    background-color: var(--light);
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    padding: 1rem;
    z-index: 4;

    -webkit-box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.4);
    -moz-box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.4);
    box-shadow: 0px 3px 5px 0px rgba(0,0,0,0.4);

    h3 {
        align-self: left;
        color: var(--dark);
        font-size: 1.2rem;
        font-weight: bold;
    }

    button {
        background: var(--dark);
        padding: 1rem;
        font-weight: bold;
        color: var(--light);
        cursor: pointer;

        &:hover{
            background: var(--dark-alt);
        }
    }
}
</style>