<template>
    <main class="language-page">
        <rhea-upsidebar
            title="Languages List"
            element="language"
            @togglePopup="togglePopupForm" />
        <PopupForm
            :schemaSelected="schemaSelected"
            v-if="formPopup"
            @togglePopup="togglePopupForm"
            @submitForm="createLanguage">
            <h3 class="popup-title">Language Creation Form</h3>
        </PopupForm>
        <div class="content">
            <article>
                <language-card @click='selectLanguage(language)'
                    v-for="(language, index) in languages"
                    :key="index"
                    :name="language.name"
                    :description="language.description"
                    :metamodels="language.metamodels"/>
            </article>
            <aside>
                <FormKit type="form" ref="languageForm" v-if="languageSelected" :actions="false" @submit="submitHandler(languageSelected)" v-model="languageSelected">
                    <FormKitSchema :schema="schemaSelected" />
                </FormKit>
                <div class="button-container" v-if="languageSelected">
                    <button @click="submitForm">Save changes</button>
                    <button @click="deleteSelected">Delete Language</button>
                </div>
                <h3 class="no-selection" v-else>No language selected</h3>
            </aside>
        </div>
    </main>
</template>

<script>
import RheaUpsidebar from '@/components/RheaUpsidebar.vue';
import LanguageCard from '@/components/LanguageCard.vue';

import PopupForm from '@/components/PopupForm.vue';
import { FormKitSchema } from '@formkit/vue';

export default {
    name: 'language-view',
    components: {RheaUpsidebar, LanguageCard, FormKitSchema, PopupForm},

    data () {
        return {
            languages: [
                {
                    id: '1', name: 'Basic',
                    description: 'A simple language.',
                    metamodels: ['Basic']
                },
                {
                    id: '2', name: 'Relationed',
                    description: 'Language that allows relations.',
                    metamodels: ['Basic', 'Cardinal Mutex']
                },
                {
                    id: '3', name: 'Complex',
                    description: 'Complex language with multiple metamodels.',
                    metamodels: ['Basic', 'Non Boolean', 'Propositional Logic CTC']
                }
            ],
            showContextMenu: false,
            formPopup: false,
            languageSelected: null,
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
                },
                // {
                //     $el: 'p',
                //     attrs: {
                //         style: {
                //             'font-weight': 'bold',
                //             'font-size': '14px',
                //             'margin-bottom': '6px'
                //         }
                //     },
                //     children: 'Language Constructors'
                // },
                {
                    $formkit: 'checkbox',
                    name: 'metamodels',
                    label: 'Language Constructors',
                    options: [
                        {
                            value: 'Basic',
                            label: 'Features and Feature Models',
                            help: 'Basic Language Constructors that define a Feature and the attributes it owns.'
                        },
                        {
                            value: 'Cardinal Mutex',
                            label: 'Cardinality and Mutex groups, Multiplicity',
                            help: 'Includes new advanced groups of Feature Models that are the Mutex and the Cardinal, last of them with Multiplicity.'
                        },
                        {
                            value: 'Non Boolean',
                            label: 'Non Boolean Attributes',
                            help: 'Add Data Types to the Features.'
                        },
                        {
                            value: 'Propositional Logic CTC',
                            label: 'Propositional Logic Cross-Tree Constraints',
                            help: 'Add several types of relations as Implies, Excludes, Not, Xor...'
                        },
                    ],
                    help: 'Select the Language Constructors'
                }
                // {
                //     $formkit: 'checkbox',
                //     name: 'metamodels',
                //     label: 'M0 and M1',
                //     options: {
                //         'Basic': 'Feature and Feature Model'
                //     },
                //     help: 'Basic Language Constructors that define a Feature and the attributes it owns.',
                //     validation: 'required'
                // },
                // {
                //     $formkit: 'checkbox',
                //     name: 'metamodels',
                //     label: 'M2 and M3',
                //     options: {
                //         'Cardinal Mutex': 'Cardinality and Mutex groups, Multiplicity'
                //     },
                //     help: 'Includes new advanced groups of Feature Models that are the Mutex and the Cardinal, last of them with Multiplicity.'
                // },
                // {
                //     $formkit: 'checkbox',
                //     name: 'metamodels',
                //     label: 'M8',
                //     options: {
                //         'Non Boolean': 'Non Boolean Attributes'
                //     },
                //     help: 'Add Data Types to the Features'
                // },
                // {
                //     $formkit: 'checkbox',
                //     name: 'metamodels',
                //     label: 'M16',
                //     options: {
                //         'Propositional Logic CTC': 'Propositional Logic Cross-Tree Constraints'
                //     },
                //     help: 'Add several types of relations as Implies, Excludes, Not, Xor...'
                // }
            ]
        }
    },

    methods: {
        selectLanguage(language) {
            this.languageSelected = language;
            //console.log('Clicked element: ' + language.name);
        },

        submitForm() {
            // retrieve the core node (several ways to do this):
            const node = this.$refs.languageForm.node;
            // submit the form!
            node.submit();
        },

        submitHandler(language) {
            alert('Changes on language ' + language.name + ' saved!');
        },

        togglePopupForm() {
            this.formPopup = !this.formPopup;
        },

        createLanguage(element) {
            this.languages.push(element);
            this.formPopup = false;
        },

        deleteSelected() {
            let language = this.languageSelected;
            this.languageSelected = null;
            this.languages = this.languages.filter(item => item.id !== language.id);
        }
    },


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

