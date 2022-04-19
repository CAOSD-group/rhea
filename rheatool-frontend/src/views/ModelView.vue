<template>
    <main class="model-page">
        <rhea-upsidebar
            title="Models List"
            element="model"
            @togglePopup="togglePopupForm" />
        <PopupForm
            :schemaSelected="schemaVariation"
            v-if="formPopup"
            @togglePopup="togglePopupForm"
            @submitForm="createModel">
            <h3 class="popup-title">Model Creation Form</h3>
        </PopupForm>
        <div class="content">
            <article>
                <model-card @click='selectModel(model)'
                    v-for="(model, index) in models"
                    :key="index"
                    :name="model.name"
                    :description="model.description"
                    :languageName="model.languageName"/>
            </article>
            <aside>
                <FormKit type="form" ref="modelForm" v-if="modelSelected" :actions="false" @submit="submitHandler(modelSelected)" v-model="modelSelected">
                    <FormKitSchema :schema="schemaSelected" />
                </FormKit>
                <div class="button-container" v-if="modelSelected">
                    <button @click="submitForm">Save changes</button>
                    <button @click="deleteSelected">Delete Model</button>
                </div>
                <h3 class="no-selection" v-else>No model selected</h3>
            </aside>
        </div>
    </main>
</template>

<script>
import RheaUpsidebar from '@/components/RheaUpsidebar.vue';
import ModelCard from '@/components/ModelCard.vue';

import PopupForm from '@/components/PopupForm.vue';
import { FormKitSchema } from '@formkit/vue';

export default {
    name: 'model-view',
    components: {RheaUpsidebar, ModelCard, FormKitSchema, PopupForm},

    data () {
        return {
            models: [
                {
                    id: '1', name: 'Modelo 1',
                    description: 'Primer modelo en el lenguaje simple.',
                    languageId: '1', languageName: 'Basic',
                    features: [
                        {name: 'empty'}
                    ],
                    crossTreeConstraints: [
                        {name: 'empty'}
                    ]
                },
                {
                    id: '2', name: 'Modelo 2',
                    description: 'Un modelo creado en el lenguaje complejo.',
                    languageId: '3', languageName: 'Complex',
                    features: [
                        {name: 'empty'}
                    ],
                    crossTreeConstraints: [
                        {name: 'empty'}
                    ]
                },
                {
                    id: '3', name: 'Modelo 3',
                    description: 'Otro modelo del lenguaje complejo creado para representar un conjunto de Features con relaciones de diversa índole.',
                    languageId: '3', languageName: 'Complex',
                    features: [
                        {name: 'empty'}
                    ],
                    crossTreeConstraints: [
                        {name: 'empty'}
                    ]
                }
            ],
            showContextMenu: false,
            formPopup: false,
            modelSelected: null,
            schemaSelected: [
                {
                    $formkit: 'text',
                    name: 'name',
                    label: 'Name',
                    validation: 'required'
                },
                {
                    $formkit: 'text',
                    name: 'description',
                    label: 'Description',
                    validation: 'required'
                }
            ],
            schemaVariation: [
                {
                    $formkit: 'text',
                    name: 'name',
                    label: 'Name',
                    validation: 'required'
                },
                {
                    $formkit: 'text',
                    name: 'description',
                    label: 'Description',
                    validation: 'required'
                },
                {
                    $formkit: 'select',
                    name: 'languageName',
                    label: 'Language',
                    options: [
                        'Basic',
                        'Relationed',
                        'Complex'
                    ]
                }
            ]
        }
    },

    methods: {
        selectModel(model) {
            this.modelSelected = model;
            //console.log('Clicked element: ' + model.name);
        },

        submitForm() {
            // retrieve the core node (several ways to do this):
            const node = this.$refs.modelForm.node;
            // submit the form!
            node.submit();
        },

        submitHandler(model) {
            alert('Changes on model ' + model.name + ' saved!');
        },

        togglePopupForm () {
            this.formPopup = !this.formPopup;
        },

        createModel (element) {
            this.models.push(element);
            this.formPopup = false;
        },

        deleteSelected() {
            let model = this.modelSelected;
            this.modelSelected = null;
            this.models = this.models.filter(item => item.id !== model.id);
        }
    }
}

</script>

<style lang="scss" scoped>
.content {
    display: flex;
}

article {
    padding: 1rem;
    display: flex;
    align-content: flex-start;
    width: 75%;
    flex-flow: row;
    flex-wrap: wrap;
}

aside {
    width: 25%;
    display: flex;
    flex-direction: column;
    min-height: 92.5vh;
    overflow: hidden;
    padding: 1rem;

    background-color: var(--light);
    color: var(--dark);

    -webkit-box-shadow: inset 0 8px 5px -5px rgba(0,0,0,0.4);
    -moz-box-shadow: inset 0 8px 5px -5px rgba(0,0,0,0.4);
    box-shadow: inset 0 8px 5px -5px rgba(0,0,0,0.4);

    .button-container{
        display: flex;
        justify-content: space-between;

        button {
            width: 45%;
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

    .no-selection {
        color: gray;
        text-align: center;
        margin-top: 1rem;
    }
}

.popup-title {
    text-align: center;
    color: var(--primary);
}

</style>