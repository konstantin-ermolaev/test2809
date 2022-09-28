class BalanceService {

    private var clientBalance: Long = 0

    fun getBalance(): Long = clientBalance

    fun plusBalance(count: Long) {
        clientBalance+=count
    }

    fun minusBalance(count: Long) {
        clientBalance -= count
    }

    fun setBalance(balance: Long) {
        clientBalance = balance    }
}