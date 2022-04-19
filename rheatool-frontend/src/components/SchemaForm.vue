<template>
    <FormKit type="form" ref="form" :actions="false" v-model="elementSelected" @submit="submitHandler(elementSelected)">
        <FormKitSchema :schema="schemaSelected" />
    </FormKit>
    <slot/>
</template>

<script>
import { FormKitSchema } from '@formkit/vue';

export default { 
    name: 'schema-form',
    components: {FormKitSchema},

    props: {
        schemaSelected: Array,
        element: Object
    },

    data() {
        return {
            elementSelected: this.element
        }
    },

    methods: {
        submitForm() {
            // retrieve the core node (several ways to do this):
            const node = this.$refs.form.node;
            // submit the form!
            node.submit();
        },

        submitHandler(element) {
            alert('Changes on element ' + element.name + ' saved!');
        }
    }

}
</script>

<style lang="scss" scoped>

</style>