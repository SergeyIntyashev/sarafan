<template>
  <v-app>
    <v-toolbar app>
      <v-toolbar-title>Sarafan</v-toolbar-title>
      <v-spacer></v-spacer>
      <span v-if="profile">{{ profile.name }}&nbsp</span>
      <v-btn v-if="profile" href="/logout" icon="mdi-exit">
<!--        Exit-->
<!--        <v-icon>icons.mdExitToApp</v-icon>-->
      </v-btn>
    </v-toolbar>
    <v-container>
      <v-container v-if="!profile">Необходимо авторизоваться через
        <a href="/login">Google</a>
      </v-container>
      <v-container v-if="profile">
        <messages-list :messages="messages"/>
      </v-container>
    </v-container>
  </v-app>
</template>

<script>
import MessagesList from 'components/messages/MessageList.vue'
import {addHandler} from 'util/ws'
import { mdiExitToApp }from '@mdi/js'

export default {
  components: {
    MessagesList
  },
  data() {
    return {
      icons:{
        mdiExitToApp
      },
      messages: frontendData.messages,
      profile: frontendData.profile
    }
  },
  created() {
    addHandler(data => {
      let index = this.messages.findIndex(el => el.id === data.id)

      if (index > -1) {
        this.messages.splice(index, 1, data)
      } else {
        this.messages.push(data)
      }
      })
    }
  }
</script>

<style>
</style>