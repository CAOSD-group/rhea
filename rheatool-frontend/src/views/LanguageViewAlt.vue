<template>
    <main class="language-page-alt">
        <rhea-upsidebar title="Languages List" element="language" />
        <article>
            <context-menu :display="showContextMenu" ref="menu">
                <ul>
                    <li @click="modifyLanguage"> Modify </li>
                    <li @click="deleteLanguage"> Delete </li>
                </ul>
            </context-menu>
            <language-card @click='openContextMenu($event, language)'
                v-for="(language, index) in languages"
                :key="index"
                :name="language.name"
                :description="language.description"
                :metamodels="language.metamodels"/>

            <FormKit v-if="languageSelected" type="form">
                <FormKitSchema :schema="schemaSelected" />
            </FormKit>
        </article>
    </main>
</template>

<script>
import RheaUpsidebar from '@/components/RheaUpsidebar.vue';
import LanguageCard from '@/components/LanguageCard.vue';
import ContextMenu from '@/components/ContextMenu.vue';

import { FormKitSchema } from '@formkit/vue';

export default {
    name: 'language-view-alt',
    components: {RheaUpsidebar, LanguageCard, ContextMenu, FormKitSchema},

    data () {
        return {
            languages: [
                {
                    id: '1', name: 'Basic',
                    description: 'A simple language.',
                    metamodels: ['M0', 'M1'],
                    schema: 
                        [
                            {
                                $formkit: 'email',
                                label: 'Email address',
                                validation: 'required'
                            },
                            {
                                $formkit: 'password',
                                name: 'password',
                                label: 'Password',
                                help: 'Enter your new password.',
                                validation: 'required|length:5,16'
                            },
                            {
                                $formkit: 'password',
                                name: 'password_confirm',
                                label: 'Confirm password',
                                help: 'Enter your new password again to confirm it.',
                                validation: 'required|confirm',
                                validationLabel: 'password confirmation',
                            }
                        ]
                },
                {
                    id: '2', name: 'Relationed',
                    description: 'Language that allows relations.',
                    metamodels: ['M0', 'M1', 'M9'],
                    schema: 
                        [
                            {
                                $formkit: 'text',
                                label: 'Name',
                                validation: 'required'
                            },
                            {
                                $formkit: 'checkbox',
                                name: 'eu_citizen',
                                id: 'eu',
                                label: 'Are you a european citizen?',
                            },
                            {
                                $formkit: 'select',
                                if: '$get(eu).value',
                                name: 'cookie_notice',
                                label: 'Cookie notice frequency',
                                options: {
                                refresh: 'Every page load',
                                hourly: 'Ever hour',
                                daily: 'Every day'
                                },
                                help: 'How often should we display a cookie notice?'
                            }
                        ]
                },
                {
                    id: '3', name: 'Complex',
                    description: 'Complex language with multiple metamodels.',
                    metamodels: ['M0', 'M1', 'M4', 'M5', 'M6', 'M4', 'M5', 'M6'],
                    schema: 
                        [
                            {
                                $formkit: 'password',
                                name: 'password',
                                label: 'Password',
                                help: 'Enter your new password.',
                                validation: 'required|length:5,16'
                            },
                            {
                                $formkit: 'password',
                                name: 'password_confirm',
                                label: 'Confirm password',
                                help: 'Enter your new password again to confirm it.',
                                validation: 'required|confirm',
                                validationLabel: 'password confirmation',
                            }
                        ]
                }
            ],
            showContextMenu: false,
            languageSelected: null,
            schemaSelected: [
                {
                    
                }
            ]
        }
    },

    methods: {
        openContextMenu(e, language) {
            this.$refs.menu.open(e, language);
            console.log('Clicked element: ' + language.name);
        },
        deleteLanguage() {
            let language = this.$refs.menu.element;
            this.languages = this.languages.filter(item => item !== language);
            this.$refs.menu.close();
        },
        modifyLanguage() {
            this.languageSelected = this.$refs.menu.element;
            this.schemaSelected = this.languageSelected.schema;
            console.log(this.languageSelected.schema);
            this.$refs.menu.close();
        }
    }


}
</script>

<style lang="scss" scoped>
article {
    padding: 1rem;
    display: flex;
    flex-flow: row;
    flex-wrap: wrap;
}

ul {
    list-style: none;
}

li {
    padding: 0.5rem 1rem;
    &:hover {
        background-color: var(--light-alt);
    }
}

</style>

