<template>
    <div class="popup">
        <div class="popup-inner">
            <div class="popup-header">
                <slot/>
            </div>
            <div class="popup-content">
                <FormKit type="form" :actions="false" @submit="submitHandler(element)" v-model="element">
                    <FormKitSchema :schema="schemaSelected" />
                </FormKit>
                <div class="button-container">
                    <button @click="submitForm(element)">Create</button>
                    <button @click="togglePopup()">Cancel</button>
                </div>
            </div>
            

        </div>
    </div>
</template>

<script>
import { FormKitSchema } from '@formkit/vue';

export default {
    name: 'popup-form',
    components: {FormKitSchema},
    props: {
        schemaSelected: Array
    },
    data() {
        return {
            element: {}
        }
    },
    methods: {
        togglePopup() {
            this.$emit("togglePopup");
        },

        submitForm(element) {
            this.$emit("submitForm", element)
        }
    }
}
</script>

<style lang="scss" scoped>
.popup {
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	z-index: 99;
	background-color: rgba(0, 0, 0, 0.2);
	
	display: flex;
	align-items: center;
	justify-content: center;

	.popup-inner {
		background: #FFF;

        .popup-header {
            background: var(--dark);
            padding: 1rem;
        }
        
        .popup-content {
            padding: 1rem 2rem 1rem 2rem;
            .button-container {
                display: flex;
                justify-content: space-between;

                button {
                    width: 45%;
                    background: var(--dark);
                    padding: 1rem;
                    color: var(--light);
                    cursor: pointer;

                    &:hover {
                        background: var(--dark-alt);
                    }
                }
            }
        }
	}
}
</style>
