import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import { connect } from "./util/ws"
import { createApp } from 'vue'
import { createVuetify } from 'vuetify'
import 'vuetify/styles'
import App from 'pages/App.vue'

if (frontendData.profile){
    connect()
}

const app = createApp(App)
const vuetify = createVuetify({
    components,
    directives,
})

app.use(vuetify)

app.mount('#app')