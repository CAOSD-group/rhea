<template>
    <rhea-sidebar />
    <router-view />
</template>

<script>
import RheaSidebar from '@/components/RheaSidebar'

export default {
  name: 'app',
  components: { RheaSidebar }
}

</script>

<style lang="scss">
:root {
  --primary: #eb902a;
  --grey: #64748b;
  --dark: #1e293b;
  --dark-alt: #334155;
  --light: #f1f5f9;
  --light-alt: #e2e2e2;
  --sidebar-width: 300px;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Roboto', sans-serif;
}

body {
  background: var(--light-alt);
}

button {
  cursor: pointer;
  appearance: none;
  border: none;
  outline: none;
  background: none;
}

#app {
  display: flex;

  main {
    flex: 1 1 0;

    @media (max-width: 768px) {
      padding-left: 6rem;
    }
  }
}

.formkit-submit {
  background: #eb902a;
}

</style>
