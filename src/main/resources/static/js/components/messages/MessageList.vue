<template>
  <v-table>
    <message-form :messages="messages" :messageAttr="message"/>
    <message-row v-for="message in messages"
                 :key="message.id"
                 :message="message"
                 :editMessage="editMessage"
                 :deleteMessage="deleteMessage"
                 :messages="messages"/>
  </v-table>
</template>

<script>
import axios from 'axios'
import MessageRow from "./MessageRow.vue"
import MessageForm from "./MessageForm.vue";
export default {
  props: ['messages'],
  components: {
    MessageRow,
    MessageForm
  },
  data() {
    return {
      message: null
    }
  },
  methods: {
    editMessage(message) {
      this.message = message
    },
    deleteMessage(message) {
      axios.delete(`/message/${message.id}`).then(result => {
        if (result.status === 200){
          this.messages.splice(this.messages.indexOf(message), 1)
        }
      })
    },
  }
}
</script>

<style>

</style>