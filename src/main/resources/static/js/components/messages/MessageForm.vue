<template>
  <v-layout>
    <v-form ref="form">
      <v-row>
      <v-text-field
          label="New message"
          placeholder="Write something"
          v-model="text"/>
      <v-btn class="mr-4" @click="save"> Save</v-btn>
      </v-row>
    </v-form>
  </v-layout>
</template>

<script>
import {sendMessage} from 'util/ws'

export default {
  props: ['messages', 'messageAttr'],
  data() {
    return {
      text: '',
      id: ''
    }
  },
  watch: {
    messageAttr(newVal, oldVal) {
      this.text = newVal.text
      this.id = newVal.id
    }
  },
  methods: {
    save() {
      sendMessage({id: this.id, text: this.text})
      this.text = ''
      this.id = ''

      // const message = {text: this.text}
      //
      // if (this.id) {
      //   axios.put(`/message/${this.id}`, message).then(res => {
      //     const index = this.messages.findIndex((element) => element.id === this.id)
      //     this.messages.splice(index, 1, res.data)
      //     this.text = ""
      //     this.id = ""
      //       })
      // } else {
      //   axios.post('/message', message).then(res => {
      //     this.messages.push(res.data);
      //     this.text = ""
      //   })
      // }

    }
  }
}
</script>

<style>

</style>