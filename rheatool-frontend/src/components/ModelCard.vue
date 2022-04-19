<template>
    <section>
        <h4>{{ name }}</h4>
        <p>{{ description }}</p>
        <div class="language">
            <h6>{{ languageName }}</h6>
            <span>
                {{languageId}}
            </span>
        </div>
    </section>
</template>

<script>
export default {
    name: 'model-card',
    props: {
        id: String,
        name: String,
        description: String,
        languageId: String,
        languageName: String,
        features: Array,
        crossTreeConstraints: Array
    }
}
</script>

<style lang="scss" scoped>
section {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    width: 100%;
    
    background-color: var(--light);
    margin: 1rem;
    cursor: pointer;

    -webkit-box-shadow: 4px 4px 5px 0px rgba(0,0,0,0.4);
    -moz-box-shadow: 4px 4px 5px 0px rgba(0,0,0,0.4);
    box-shadow: 4px 4px 5px 0px rgba(0,0,0,0.4);

    transition: 0.2s ease-out;
    @media (min-width: 1200px) {
        flex-basis: 44%;
    }

    h4 {
        width: 100%;
        padding: 1rem;
        background-color: var(--dark);
        color: var(--primary);
    }

    p {
        padding: 1rem;
        margin-top: 1rem;
        margin-bottom: 1rem;
    }

    .language {
        width: 100%;
        display: flex;
        flex-wrap: wrap;
        background-color: var(--dark-alt);
        padding: 1rem;

        h6 {
            width: 100%;
            font-size: 0.8rem;
            margin-bottom: 0.5rem;
            color: var(--primary);
        }

        span {
            text-align: center;
            color: var(--light);
            margin: 0.5rem;
        }
    }
}
</style>