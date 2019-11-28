export default {
    login: function (context, username, pass) {
        return new Promise((resolve, reject) => {
            context.$http.post('/login', {
                login: username,
                password: pass
            }).then(response => {

                resolve(response)
            }).catch(response => {
                reject(response)
            })
        })
    }
}
