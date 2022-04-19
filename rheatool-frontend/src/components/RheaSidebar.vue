<template>
  <aside :class="`${is_expanded ? 'is-expanded' : ''}`">
      <div class="logo">
          <img src="../assets/icon-orange.png" alt="">
          <h3>Rhea Tool</h3>
      </div>

      <div class="menu-toggle-wrap">
          <button class="menu-toggle" @click="ToggleMenu">
              <span class="material-icons">keyboard_double_arrow_right</span>
          </button>
      </div>

      <h3>Menu</h3>
      <div class="menu">
          <router-link class="button" to="/">
            <span class="material-icons">image_aspect_ratio</span>
            <span class="text">Languages</span>
          </router-link>
          <router-link class="button" to="/model">
            <span class="material-icons">account_tree</span>
            <span class="text">Models</span>
          </router-link>
          <router-link class="button" to="/alt">
            <span class="material-icons">info</span>
            <span class="text">Information</span>
          </router-link>
      </div>

      <div class="flex"></div>

      <div class="menu">
          <router-link class="button" to="/alt">
            <span class="material-icons">account_circle</span>
            <span class="text">Account</span>
          </router-link>
      </div>
  </aside>
</template>

<script setup>
import { ref } from 'vue'

const is_expanded = ref(localStorage.getItem("is_expanded") === "true")

const ToggleMenu = () => {
    is_expanded.value = !is_expanded.value

    localStorage.setItem("is_expanded", is_expanded.value)
    }
</script>

<style lang="scss" scoped>
aside {
    display: flex;
    flex-direction: column;
    width: calc(2rem + 32px);
    min-height: 100vh;
    overflow: hidden;
    padding: 1rem;

    background-color: var(--dark);
    color: var(--light);
    z-index: 5;

    .logo {
        display: flex;
        align-items: center;
        margin-bottom: 1rem;

        img {
            width: 2rem;
            height: 2rem;
        }

        h3 {
            opacity: 0;
            transition: 0.1s ease-out;
            margin-bottom: 0;
            margin-left: 0.5rem;
        }
    }

    .flex {
        flex: 1 1 0;
    }

    .menu-toggle-wrap {
        display: flex;
        justify-content: flex-end;
        margin-bottom: 1rem;

        position: relative;
        top: 0;
        transition: 0.2s ease-out;

        .menu-toggle {
            transition: 0.2s ease-out;

            .material-icons {
                font-size: 2rem;
                color: var(--light);
                transition: 0.2s ease-out;
            }

            &:hover {
                .material-icons {
                    color: var(--primary);
                    transform: translateX(0.5rem);
                }
            }
        }
    }

    h3, .button .text {
        opacity: 0;
        transition: 0.3s ease-out;
    }

    h3 {
        color: var(--grey);
        font-size: 0.875rem;
        margin-bottom: 0.5rem;
        text-transform: uppercase;
    }

    .menu {
        margin: 0 -1rem;

        .button {
            display: flex;
            align-items: center;
            text-decoration: none;

            padding: 0.5rem 1rem;
            transition: 0.2s ease-out;

            .material-icons {
                font-size: 2rem;
                color: var(--light);
                transition: 0.2s ease-out;
            }

            .text {
                color: var(--light);
                transition: 0.2s ease-out;
            }

            &:hover, &.router-link-exact-active {
                background-color: var(--dark-alt);

                .material-icons, .text {
                    color: var(--primary);
                }
            }

            &.router-link-exact-active {
                border-right: 5px solid var(--primary);
            }
        }
    }

    &.is-expanded {
        width: var(--sidebar-width);

        .menu-toggle-wrap {
            top: -3rem;
            .menu-toggle {
                transform: rotate(-180deg);
            }
        }

        h3, .button .text {
            opacity: 1;
        }

        .button {
            .material-icons {
                margin-right: 1rem;
            }
        }
    }

    transition: 0.2s ease-out;
    @media (max-width: 768px) {
        position: fixed;
        z-index: 99;
    }
}
</style>